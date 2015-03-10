#include<string.h>
#include<stdio.h>
#include<jni.h>
jstring
Java_com_example_hellondk_MainActivity_getText(JNIEnv* env,jobject obj)
{
	return(*env)->NewStringUTF(env,"Hello NDK");
}
Java_com_example_hellondk_MainActivity_getText2(JNIEnv* env,jobject obj)
{
	return(*env)->NewStringUTF(env,"Hello NDK2");
}
