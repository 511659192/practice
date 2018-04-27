package com.example.demo.asm;

import jdk.internal.org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by ym on 2018/4/1.
 */
public class AsmTest implements Opcodes {

    public static void main(String[] args) throws Exception {

//        Class<?> clazz = DefineClassHelper.toClass("com.example.demo.classConstruct.Person2", AsmTest.class.getClassLoader(), AsmTest.class.getProtectionDomain(), dump());
//        Object instance = clazz.newInstance();
        new FileOutputStream(new File("Person21.class")).write(dump());

    }
    public static byte[] dump3 () throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "com/example/demo/classConstruct/Mapper", null, "java/lang/Object", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "mapper", "(Lcom/example/demo/classConstruct/Entity;)Lcom/example/demo/classConstruct/Entity;", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "com/example/demo/classConstruct/Entity");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "com/example/demo/classConstruct/Entity", "<init>", "()V", false);
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField02", "()Ljava/lang/Byte;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField01", "(B)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField01", "()B", false);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField02", "(Ljava/lang/Byte;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField03", "()I", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField03", "(I)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField04", "()Ljava/lang/Integer;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField04", "(Ljava/lang/Integer;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField05", "()S", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField05", "(S)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField06", "()Ljava/lang/Short;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField06", "(Ljava/lang/Short;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField07", "()C", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField07", "(C)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField08", "()Ljava/lang/Character;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField08", "(Ljava/lang/Character;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField04", "()Ljava/lang/Integer;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
            mv.visitInsn(I2L);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField09", "(J)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField03", "()I", false);
            mv.visitInsn(I2L);
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField10", "(Ljava/lang/Long;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "isField11", "()Z", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField11", "(Z)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField12", "()Ljava/lang/Boolean;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField12", "(Ljava/lang/Boolean;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField13", "()Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField13", "(Ljava/lang/String;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField14", "()Ljava/util/Map;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField14", "(Ljava/util/Map;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField15", "()Ljava/util/List;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField15", "(Ljava/util/List;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField16", "()Ljava/util/Set;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField16", "(Ljava/util/Set;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(3, 3);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }

    public static byte[] dump2 () throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "com/example/demo/classConstruct/Mapper", null, "java/lang/Object", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "mapper", "(Lcom/example/demo/classConstruct/Entity;)Lcom/example/demo/classConstruct/Entity;", null, null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "com/example/demo/classConstruct/Entity");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "com/example/demo/classConstruct/Entity", "<init>", "()V", false);
            mv.visitVarInsn(ASTORE, 2);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField01", "()B", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField01", "(B)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField02", "()Ljava/lang/Byte;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField02", "(Ljava/lang/Byte;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField03", "()I", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField03", "(I)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField04", "()Ljava/lang/Integer;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField04", "(Ljava/lang/Integer;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField05", "()S", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField05", "(S)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField06", "()Ljava/lang/Short;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField06", "(Ljava/lang/Short;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField07", "()C", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField07", "(C)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField08", "()Ljava/lang/Character;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField08", "(Ljava/lang/Character;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField09", "()J", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField09", "(J)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField10", "()Ljava/lang/Long;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField10", "(Ljava/lang/Long;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "isField11", "()Z", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField11", "(Z)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField12", "()Ljava/lang/Boolean;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField12", "(Ljava/lang/Boolean;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField13", "()Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField13", "(Ljava/lang/String;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField14", "()Ljava/util/Map;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField14", "(Ljava/util/Map;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField15", "()Ljava/util/List;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField15", "(Ljava/util/List;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "getField16", "()Ljava/util/Set;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "com/example/demo/classConstruct/Entity", "setField16", "(Ljava/util/Set;)V", false);
            mv.visitVarInsn(ALOAD, 2);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(3, 3);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }

    public static byte[] dump () throws Exception {

//        ClassWriter cw = new ClassWriter(0);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "com/example/demo/classConstruct/Person2", "<E:Ljava/lang/Object;>Ljava/lang/Object;", "java/lang/Object", null);

        {
            av0 = cw.visitAnnotation("Lorg/springframework/stereotype/Controller;", true);
            av0.visitEnd();
        }
        {
            fv = cw.visitField(ACC_PRIVATE, "name", "Ljava/lang/Object;", "TE;", null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(10, 10);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getName", "()Ljava/lang/Object;", "()TE;", null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "com/example/demo/classConstruct/Person2", "name", "Ljava/lang/Object;");
            mv.visitInsn(ARETURN);
            mv.visitMaxs(10, 10);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "setName", "(Ljava/lang/Object;)V", "(TE;)V", null);
            {
                av0 = mv.visitAnnotation("Lorg/springframework/web/bind/annotation/RequestMapping;", true);
                av0.visitEnd();
            }
            {
                av0 = mv.visitAnnotation("Lorg/springframework/web/bind/annotation/ResponseBody;", true);
                av0.visitEnd();
            }
            {
                av0 = mv.visitParameterAnnotation(0, "Lorg/springframework/web/bind/annotation/PathVariable;", true);
                av0.visitEnd();
            }
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitFieldInsn(PUTFIELD, "com/example/demo/classConstruct/Person2", "name", "Ljava/lang/Object;");
            mv.visitInsn(RETURN);
            mv.visitMaxs(10, 10);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "getT", "()Ljava/lang/Object;", "<T:Ljava/lang/Object;>()TT;", null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, "java/lang/Object");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(10, 10);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }
}
