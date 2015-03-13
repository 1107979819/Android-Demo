#include<string.h>
#include<stdio.h>
#include<jni.h>
jstring Java_com_example_hellondk_MainActivity_getText(JNIEnv* env,jobject obj)
{
	return(*env)->NewStringUTF(env," Hello NDK-1");
}
jstring Java_com_example_hellondk_MainActivity_getText2(JNIEnv* env,jobject obj)
{
	return(*env)->NewStringUTF(env," Hello NDK-2");
}
jstring Java_com_example_hellondk_MainActivity_getText3(JNIEnv* env,jobject obj)
{
	return(*env)->NewStringUTF(env," Hello NDK-3");
}
jint Java_com_example_hellondk_MainActivity_getInt(JNIEnv* env,jobject obj)
{
	return 1;
}
JNIEXPORT jint JNICALL Java_com_example_hellondk_MainActivity_AddInt
  (JNIEnv *env, jclass arg, jint a, jint b)
{
    return a + b;
}

