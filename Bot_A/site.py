#!/usr/bin/env python
# coding: utf-8

import webbrowser
import functions as funcs
def browser():
    sites = {"https://vk.com":["vk","вк"], 'https://www.youtube.com/':['youtube', 'ютуб'], 'https://ru.wikipedia.org': ["вики", "wiki"], 'https://ru.aliexpress.com':['али', 'ali', 'aliexpress', 'алиэспресс'], 'http://google.com':['гугл','google'], 'https://www.amazon.com':['амазон', 'amazon'], 'https://www.apple.com/ru':['apple','эпл'], 'https://telete.in/gurupython':['пайтонгуру', 'pythonguru']}
    site = funcs.voice.split()[-1]
    for k, v in sites.items():
        for i in v:
            if i not in site.lower():
                open_tab = None
            else:
                open_tab = webbrowser.open_new_tab(k)
                break

        if open_tab is not None:
            break
