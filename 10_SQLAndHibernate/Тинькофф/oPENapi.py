#!/usr/bin/env python
# coding: utf-8
from openapi_client import openapi

#token = '  тут надо вставить свой токен , который можно получить прямо из приложения ... ' 
client = openapi.api_client(token)

#    print('currency:', op.currency)
#    print('balance:', op.balance)
#    print('figi:', op.figi)
#    print('ticker:', op.ticker)
#    print('name:', op.name)


#    print('value:', pf.payload.positions[0].average_position_price.value)
#    print('currency:', pf.payload.positions[0].average_position_price.currency)
#    print('balance:', pf.payload.positions[0].balance)
#    print('figi:', pf.payload.positions[0].figi)
#    print('ticker:', pf.payload.positions[0].ticker)
#    print('name:', pf.payload.positions[0].name)


from datetime import datetime
from pytz import timezone

# Качаем все операции с 1 января 2016 (я один из первых клиентов Тиньков Инвестиции)
d1 = datetime(2016, 1, 1, 0, 0, 0, tzinfo=timezone('Europe/Moscow'))  # timezone нужно указывать. Иначе - ошибка
d2 = datetime.now(tz=timezone('Europe/Moscow'))  # По настоящее время
ops = client.operations.operations_get(_from=d1.isoformat(), to=d2.isoformat())
#
print('- Все Операции -')
for oper in ops.payload.operations: # Перебираем операции
    print(oper) # figi всегда берем из операции
#    print(op.figi) # figi всегда берем из операции
#    print(op.operation_type)   # и тип операции тоже
    if oper.trades == None:      # Если биржевых сделок нет
        print('price:', oper.price)       # Берем из операции цену бумаги
        print('payment:', oper.payment)   # Сумму платежа
        print('Количество бумаг:', oper.quantity) # И количество бумаг
    else:    
        for t in oper.trades:                   # А если есть сделки - то перебираем их
            print('price:', t.price)          # И берем данные из них
            print('quantity:', t.quantity)
    print('--------------')
print('- Конец списка Операций -')


print('- ПОРТФЕЛЬ -')

pf = client.portfolio.portfolio_get()
for op in pf.payload.positions: # Перебираем портфель
    print('value:', op.lots , op.balance, op.name, op.expected_yield.value)


'''
И вот теперь интересно как пристегнуть это все к терминалу MT5 , что бы иметь возможность торговать из MT5 в этом чудесном банке.

Когда общался с поддержкой сообщили что MT5 они не планируют ставить. Хотя возможно не с теми общался.

Рынок и физика его глобальных закономерностей
Планируется ли поддержка fix протокола в mt5?
Читать данные из чужого приложения , чтение котировок из одного терминала в другой , игра на разнице - Арбитраж.
Yuriy Zaytsev
20005
Yuriy Zaytsev 2020.08.03 09:42 #1   
открыть позицию, точнее выставить  лимитник
'''


from openapi_client import openapi
from datetime import datetime, timedelta
from pytz import timezone

token = 'YOUR TOKEN'
client = openapi.sandbox_api_client(token)
client.sandbox.sandbox_register_post()
client.sandbox.sandbox_clear_post()
client.sandbox.sandbox_currencies_balance_post(sandbox_set_currency_balance_request={"currency": "USD", "balance": 1000})


def set_balance():
    balance_set = client.sandbox.sandbox_currencies_balance_post({"currency": "USD", "balance": 10000})
    print("balance")
    print(balance_set)
    print()


def print_24hr_operations():
    now = datetime.now(tz=timezone('Europe/Moscow'))
    yesterday = now - timedelta(days=1)
    ops = client.operations.operations_get(_from=yesterday.isoformat(), to=now.isoformat())
    print("operations")
    print(ops)
    print()


def print_orders():
    orders = client.orders.orders_get()
    print("active orders")
    print(orders)
    print()


def make_order():
    order_response = client.orders.orders_limit_order_post(figi='BBG009S39JX6',
                                                           limit_order_request={"lots": 1,
                                                                                "operation": "Buy",
                                                                                "price": 0.01})
    print("make order")
    print(order_response)
    print()
    return order_response


# won't work in sandbox - orders are being instantly executed
def cancel_order(order_id):
    cancellation_result = client.orders.orders_cancel_post(order_id=order_id)
    print("cancel order")
    print(cancellation_result)
    print()


set_balance()
print_24hr_operations()
print_orders()
order_response = make_order()
print_orders()
# cancel_order(order_response.payload.order_id)
# print_orders()
