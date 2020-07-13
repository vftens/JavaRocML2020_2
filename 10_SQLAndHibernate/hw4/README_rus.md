���� �������

� ������� Hibernate �������� ����� ������� � ���� ������ � ��������� �.

� ���� Skillbox ���� ������� PurchaseList. � ��� ������� ����� ��������� � �������� ������, ������� ��� ������.

��� ����� �������

�������� ��� ����� ������� LinkedPurchaseList, ������� ����������� �� ��������� ������ ������� PurchaseList.

������� ������ ��������� ��������� ����:

student_id
course_id
� ������� ��� ��������� ������� � ��������� ��������������� ������. � ���� �������������� ����� ��������� ���� student_id � course_id.  ��� ������, ��� ���� �������� student_id � course_id ��������� ��� ������ ������.

������ student_id � course_id ���������� ���������� ����� (Composite key). 

���� �� ��������� �������� ���������� ����� � �������� ��������� �����, � ������� ���� ����� ��������� �������� �����, �������� � ��������� ����.

�� ������� ������ Subscription:

public class Key implements Serializable {

@Column(name = "student_id")

    private int studentId;

@Column(name = "course_id")

    private int courseId;

 //setters, getters, equals(), hashcode()

}



����� ���������� ����� ������:

���� public;
����� ��������� ����������� �� ���������;
������������� ����������� equals(), hashCode(), ��������� ������� � �������;
���������������� Serializable.
 ������������ �����-���� � @Entity ��������� �������:

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

 

��������� @EmbeddedId �������, ��� ������ �������� �������� ��������� ������.

���� ���� ����� ������������ � � �������� ������ @Entity, �� ���������� ��������� ������������ ���� ��� ������� � ���������� ������ ��������������� ����������� � ��������� @Column.

 

��� ��������� ������� �� ���� ������ �� ���������� ����� ���������� � ����� get() ������� Session ���������� ��������� ���������� �����, ��������:

Subscription subscription = session.get(Subscription.class, new PK(studentId, courseId));

���������� � ��� �������� ����� ������.



�������������� ������� ������ � ������.



 ������������

�������� �������� hbm2ddl.auto �� update � hibernate.cfg, ����� ��������� ���� ������ ����������� � ����������� �� ����������� ���� ������� @Entity.
������ ��������� ��������� hbm2ddl.auto:
validate � ��������� �����, �� ������� ��������� � ���� ������;
update � �������� �����;
create � ������ �����, ��������� ���������� ������;
create-drop � ���������� �� �����, ����� SessionFactory ����������� ���� � ������, ����� ���������� �����������.
�������� ������

������ � � ���� ������ ������� ������� LinkedPurchaseList � ��������� �� ������ PurchaseList.
