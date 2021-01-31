#!/usr/bin/env python
# coding: utf-8

# In[1]:


import random
import nltk


# In[2]:


BOT_CONFIG = {
    'intents': {
        'hello': {
            'examples': ['Привет', 'Добрый день', 'Добрый вечер', 'Здравствуйте', 'Шалом', 'Приветики'],
            'responses': ['Привет, человек!', 'Здравствуйте']
        },
        'bye': {
            'examples': ['Пока', 'Досвидания', 'До свидания', 'Прощайте'],
            'responses': ['Еще увидимся', 'Если что, я тут']
        },
    },

    'failure_phrases': [
        'Не понятно. Перефразируй, пожалуйста',
        'Я еще только учусь. Не умею на такое отвечать',
    ]
}


# In[3]:


def clear_text(text):
    text = text.lower()
    text = ''.join(char for char in text if char in 'абвгдеёжзийклмнопрстуфхцчшщъыьэюя -')
    return text


# In[10]:


def classify_intent(replica):
    replica = clear_text(replica)

    for intent, intent_data in BOT_CONFIG['intents'].items():
        for example in intent_data['examples']:
            example = clear_text(example)

            distance = nltk.edit_distance(replica, example)

            if len(example) and distance / len(example) < 0.3:
                return intent


# In[11]:


def get_answer_by_intent(intent):
    if intent in BOT_CONFIG['intents']:
        responses = BOT_CONFIG['intents'][intent]['responses']
        return random.choice(responses)


# In[12]:


def generate_answer(replica):
    # TODO 3rd day
    return


# In[13]:


def get_stub():
    failure_phrases = BOT_CONFIG['failure_phrases']
    return random.choice(failure_phrases)


# In[14]:


def bot(replica):
    # NLU
    intent = classify_intent(replica)

    # Получение ответа

    # правила
    if intent:
        answer = get_answer_by_intent(intent)
        if answer:
            return answer

    # генеративная модель
    answer = generate_answer(replica)
    if answer:
        return answer

    # заглушка
    answer = get_stub()
    return answer


# In[19]:


print(bot('Какую музыку послушать?'))


# In[ ]:




