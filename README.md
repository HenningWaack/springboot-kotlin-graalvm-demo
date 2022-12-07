# Demo for Spring Boot Native with Kotlin

Run the following command to create a native image 

```shell
./gradlew nativeBuild
```

Run the image:

```shell
./build/native/nativeCompile/graal-server
```

Some GraalVM exception showld pop up, either

``shell
java.lang.UnsupportedOperationException: Kotlin class com.example.demo.basics.Customer has no .copy(…) method for property id
        at org.springframework.data.mapping.model.BeanWrapper$KotlinCopyUtil.setProperty(BeanWrapper.java:171) ~[na:na]
...

or 

```shell
com.oracle.svm.core.jdk.UnsupportedFeatureError: Runtime reflection is not supported for public static com.example.demo.basics.Customer com.example.demo.basics.Customer.copy$default(com.example.demo.basics.Customer,java.lang.Long,java.lang.String,int,java.lang.Object)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.util.VMError.unsupportedFeature(VMError.java:89) ~[na:na]
        at java.base@19.0.1/java.lang.reflect.Method.acquireMethodAccessor(Method.java:71) ~[graal-server:na]
        at java.base@19.0.1/java.lang.reflect.Method.invoke(Method.java:575) ~[graal-server:na]
        at kotlin.reflect.jvm.internal.calls.CallerImpl$Method.callMethod(CallerImpl.kt:97) ~[graal-server:1.7.21-release-272(1.7.21)]
        at kotlin.reflect.jvm.internal.calls.CallerImpl$Method$Static.call(CallerImpl.kt:106) ~[na:na]
        at kotlin.reflect.jvm.internal.KCallableImpl.callDefaultMethod$kotlin_reflection(KCallableImpl.kt:173) ~[graal-server:1.7.21-release-272(1.7.21)]
        at kotlin.reflect.jvm.internal.KCallableImpl.callBy(KCallableImpl.kt:112) ~[graal-server:1.7.21-release-272(1.7.21)]
        at org.springframework.data.mapping.model.BeanWrapper$KotlinCopyUtil.setProperty(BeanWrapper.java:175) ~[na:na]
        at org.springframework.data.mapping.model.BeanWrapper.setProperty(BeanWrapper.java:79) ~[na:na]
        ...
```

Uncomment the `nativeBuild` section in the `build.gralde.kt` file:

```kotlin
nativeBuild {
	configurationFileDirectories.from(file("./config"))
}
```

After recompile/re-build, native image should work fine.