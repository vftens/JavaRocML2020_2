#
import gradio as gr
from transformers import pipeline

translation_pipeline = pipeline('translation_en_to_fr')
print("Listening en to fr")

while(True):
    answer=translation_pipeline(input())
    print(answer[0]['translation_text'])

def translate_transformers(from_text):
    result = translation_pipeline(from_text)
    return(result[0]['translation_text'])

interface = gr.Interface(fn=translate_transformers, inputs=gr.inputs.Textbox(lines=2, placeholder='Text to translate'), outputs='text')

interface.launch()



