#
apikey=''
url=''

from ibm_watson import LanguageTranslatorV3
from ibm_cloud_sdk_core.authenticators import IAMAuthenticator

authenticator = IAMAuthenticator(apikey)
lt = LanguageTranslatorV3(version='2018-05-01', authenticator=authenticator)
lt.set_service_url(url)

translation = lt.translate(text='Hello World!', model_id='en-de').get_result()

language = lt.identify_language('This is a regular phrase.').get_result()
