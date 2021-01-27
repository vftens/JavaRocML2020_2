****
Цель задания

С помощью Hibernate создайте новую таблицу в базе данных и заполните её.

В базе Skillbox есть таблица PurchaseList. В ней указаны имена студентов и названия курсов, которые они купили.

Что нужно сделать

Напишите код новой таблицы LinkedPurchaseList, которая заполняется на основании данных таблицы PurchaseList.

Таблица должна содержать следующие поля:

student_id
course_id
В таблице нет отдельной колонки с привычным идентификатором записи. В роли идентификатора здесь выступает пара student_id и course_id. 
 Это значит, что пара значений student_id и course_id уникальна для каждой записи.

Связка student_id и course_id называется «составной ключ» (Composite key). 

Один из вариантов создания составного ключа — написать отдельный класс, в котором поля будут содержать значения полей, входящих в составной ключ.

На примере класса Subscription:

public class Key implements Serializable {

@Column(name = "student_id")

    private int studentId;

@Column(name = "course_id")

    private int courseId;

 //setters, getters, equals(), hashcode()

}



Класс составного ключа обязан:

быть public;
иметь публичный конструктор по умолчанию;
реализовывать собственные equals(), hashCode(), публичные геттеры и сеттеры;
имплементировать Serializable.
 Используется класс-ключ в @Entity следующим образом:

@Entity

@Table(name = "Subscriptions")

public class Subscription {

  @EmbeddedId

  private Key id;

  @Column(name = "student_id", insertable = false, updatable = false)

  private int studentId;

  @Column(name = "course_id", insertable = false, updatable = false)

  private int courseId;

...

 

Аннотация @EmbeddedId говорит, что данный параметр является составным ключом.

Если поля ключа использовать и в основном классе @Entity, то необходимо запретить использовать поля для вставки и обновления данных дополнительными параметрами в аннотации @Column.

 

Для получения объекта из базы данных по составному ключу необходимо в метод get() объекта Session передавать экземпляр составного ключа, например:

Subscription subscription = session.get(Subscription.class, new PK(studentId, courseId));

аналогично и для создания новой записи.



Дополнительные примеры найдёте в статье.



 Рекомендации

Измените параметр hbm2ddl.auto на update в hibernate.cfg, чтобы структура базы данных обновлялась в зависимости от написанного кода классов @Entity.
Список возможных вариантов hbm2ddl.auto:
validate — проверить схему, не вносить изменения в базу данных;
update — обновить схему;
create — создаёт схему, уничтожая предыдущие данные;
create-drop — отказаться от схемы, когда SessionFactory закрывается явно — обычно, когда приложение остановлено.

