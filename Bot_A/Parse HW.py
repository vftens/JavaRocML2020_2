#!/usr/bin/env python
# coding: utf-8

# In[1]:


fname = 'ДЗ1.csv'

import csv

with open(fname) as f:
    reader = csv.DictReader(f)
    print(reader.fieldnames)
    lines = list(reader)

codes = [l['Ячейка с BOT_CONFIG'] for l in lines]
print(len(codes))


# In[14]:


config_codes[12]


# In[10]:


config_codes = []

for code in codes:
    if 'BOT_CONFIG =' in code:
        code = code.split('BOT_CONFIG =')[1]
    if 'bot_config =' in code:
        code = code.split('bot_config =')[1]
    if 'BOT_CONFIG=' in code:
        code = code.split('BOT_CONFIG=')[1]
    if 'BOT_CONFIG  =' in code:
        code = code.split('BOT_CONFIG  =')[1]
    if 'def ' in code:
        code = code.split('\ndef ')[0]

    code = code.strip()

    config_codes.append(code)

print(len(config_codes))


# In[21]:


d = eval("{'a': 'b'}")
print(type(d), d)


# In[24]:


try:
    response = eval("{'a': 'b'")
    print(response)
except:
    print(1)

print(2)


# In[25]:


configs = []
errors = 0
for code in config_codes:
    try:
        configs.append(eval(code))
    except Exception as e:
        print(code)
        print('-' * 30)
        print(e)
        print('-' * 100)
        errors += 1


# In[26]:


print(f'{errors} errors ({errors / len(config_codes) * 100:.2f}%)')
print(len(configs), 'configs')


# In[27]:


big_config = {
    'intents': {},
    'failure_phrases': []
}

for config in configs:
    if isinstance(config, dict):
        if 'intents' in config:
            for intent, value in config['intents'].items():
                if intent not in big_config['intents']:
                    big_config['intents'][intent] = {
                        'examples': [],
                        'responses': []
                    }
                if isinstance(value, dict):
                    big_config['intents'][intent]['examples'] += value.get('examples', [])
                    big_config['intents'][intent]['responses'] += value.get('responses', [])
        big_config['failure_phrases'] += config.get('failure_phrases', [])


# In[28]:


for intent, value in big_config['intents'].items():
    value['examples'] = list(set(value['examples']))
    value['responses'] = list(set(value['responses']))
    value['examples'] = [s.strip() for s in value['examples'] if isinstance(s, str) and s.strip()]
    value['responses'] = [s.strip() for s in value['responses'] if isinstance(s, str) and s.strip()]

big_config['failure_phrases'] = list(set(big_config['failure_phrases']))
big_config['failure_phrases'] = [s.strip() for s in big_config['failure_phrases'] if isinstance(s, str) and s.strip()]


# In[29]:


big_config


# In[30]:


# намерений
print(len(big_config['intents']))


# In[31]:


# примеров
print(sum(len(intent_data['examples']) for intent_data in big_config['intents'].values()))


# In[32]:


# ответов
print(sum(len(intent_data['responses']) for intent_data in big_config['intents'].values()))


# In[33]:


# заглушек
print(len(big_config['failure_phrases']))


# In[34]:


print(big_config)


# In[ ]:




