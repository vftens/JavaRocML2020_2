#
import gradio as gr
from transformers import pipeline


translation_pipeline = pipeline('translation_en_to_de')
print("Listening en to de")

while(True):
    answer=translation_pipeline(input())
    print(answer[0]['translation_text'])

def translate_transformers(from_text):
    result = translation_pipeline(from_text)
    return(result[0]['translation_text'])

