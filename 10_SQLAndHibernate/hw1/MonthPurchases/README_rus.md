���� �������

��������� ���������� MySQL � ������� � ������ ������ � ����.

��� ����� �������

�������� ���, ������� ������� ������� ���������� ������� � ����� ��� ������� ����� �� 2018 ���. ���������� �������� �������, � ������� �������� ���� �������. ��������� � �������.

���������� ������������ ������ SQL, ��� ����  ����������� �� ������� ����� ������� � � ������� Java.

������ ������� ��� ����� ����-����������� c ���� �� PRO�

SELECT pl.course_name, pl.subscription_date FROM PurchaseList pl WHERE pl.course_name = "���-����������� c 0 �� PRO" ORDER BY pl.subscription_date;

course_name               |subscription_date  |

--------------------------|-------------------|

���-����������� c 0 �� PRO|2018-01-02 00:00:00|

���-����������� c 0 �� PRO|2018-02-16 00:00:00|

���-����������� c 0 �� PRO|2018-04-02 00:00:00|

���-����������� c 0 �� PRO|2018-05-17 00:00:00|

���-����������� c 0 �� PRO|2018-07-01 00:00:00|

���-����������� c 0 �� PRO|2018-08-15 00:00:00|

���-����������� c 0 �� PRO|2019-08-15 00:00:00|



����� ����������� � ������ �� ������, �� ���� ������ �������. ����� ���� ������� ���� ��������. ������, ������� �������� ������ ��� ����� ����-����������� c ���� �� PRO� = 0,875.

��� ��������� �������� ������ �� ���� � �������� �������� ����������� ������� 

MONTH( date_value )

https://oracleplsql.ru/function-sql-server-month.html



������ �������������:



SELECT * FROM Students s 

WHERE MONTH(s.registration_date ) = 4;



������ ������� ���� ���������, ������������������ � ������:



id|name              |age|registration_date  |

--|------------------|---|-------------------|

14|������� �����     | 31|2016-04-01 00:00:00|

15|�������� �����    | 32|2016-04-08 00:00:00|

16|�������� ���������| 33|2016-04-15 00:00:00|

17|������ ��������   | 34|2016-04-22 00:00:00|

18|������� �������   | 35|2016-04-29 00:00:00|

67|������� �������   | 34|2017-04-07 00:00:00|

68|�������� ����     | 35|2017-04-14 00:00:00|

69|����������� ������| 36|2017-04-21 00:00:00|

70|�������� ������   | 37|2017-04-28 00:00:00|



���� � ��� ������ �� ������������ �������� �����.
ERROR: The server time zone value �?�???????� is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specific time zone value if you want to utilize time zone support.

�������:
�������� � ���� ������ ���������� � ����� ������ ��������, ����������� ������� ����, serverTimezone=UTC ��� ������� ���������� ������� ����, �������� serverTimezone=Europe/Moscow.

���� ������ ����� ��������� ���:
jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC



�������� ������

������ � � ������� ��������� ������� ���������� ������� ������ � ����� �� 2018 ���.
