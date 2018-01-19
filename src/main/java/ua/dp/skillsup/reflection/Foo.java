package ua.dp.skillsup.reflection;

public class Foo {

        @Execute
        public void bar(@Env("JAVA_HOME") String javaHome){
            System.out.println(javaHome);
        }
    }


