#
from py4j.java_gateway import JavaGateway
gateway = JavaGateway()                        # connect to the JVM
gateway.jvm.java.lang.System.out.println('Hello World!')
