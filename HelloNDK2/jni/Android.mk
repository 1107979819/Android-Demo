LOCAL_PATH	:=$(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE	:=mylib
LOCAL_SRC_FILES	:=source.c calc.c	

include $(BUILD_SHARED_LIBRARY)