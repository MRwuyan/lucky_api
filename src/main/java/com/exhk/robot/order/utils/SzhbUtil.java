package com.exhk.robot.order.utils;

import com.exhk.robot.order.Robot3KlineApp;
import com.exhk.robot.order.bean.exception.AccountStatusException;
import com.exhk.robot.order.common.conts.BizCode;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SzhbUtil {

    public static String buildAccountCoinKey(Integer accountId, Integer coinDefineId){
        return  accountId+"_"+coinDefineId;
    }


    public static void checkValid(BindingResult bindingResult) throws AccountStatusException {
        if(bindingResult.hasErrors()){
            throw new AccountStatusException(BizCode.FAIL, bindingResult.getFieldError().getDefaultMessage());
        }
    }


    /**
     * 获取两个字符串合并后，排序后 唯一的字符串，   S2,S1 不分先后
     * @param s1
     * @param oth 可变参数,多个效果也是一样
     * @return
     */
    public static String uniqString(String s1,String... oth){

        if(oth==null){
            return  s1;
        }

        StringBuilder ss= new StringBuilder(s1);
        if(oth.length>0){
            for (String s : oth) {
                ss.append(s);
            }
        }


        char[] ssc= ss.toString().toCharArray();
        List<Character> list=new ArrayList<Character>(  );
        for(char k : ssc){
            list.add(k);
        }

        list= list.stream().sorted().collect(Collectors.toList());

        StringBuilder str = new StringBuilder();
        for(char k : list){
            str.append(k);
        }
        return  str.toString();
    }



    public static String getProjectPath() {

        java.net.URL url = Robot3KlineApp.class.getProtectionDomain().getCodeSource()
                .getLocation();
        String filePath = null;
        try {
            filePath = java.net.URLDecoder.decode(url.getPath(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (filePath.endsWith(".jar"))
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        java.io.File file = new java.io.File(filePath);
        filePath = file.getAbsolutePath();
        return filePath;
    }


    /**
     * 获取项目所在路径
     *
     * @return
     */
    public static String getRealPath() {
        String realPath = Robot3KlineApp.class.getClassLoader().getResource("")
                .getFile();
        java.io.File file = new java.io.File(realPath);
        realPath = file.getAbsolutePath();
        try {
            realPath = java.net.URLDecoder.decode(realPath, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return realPath;


    }


    public static String getAppPath(Class<?> cls) {
        // 检查用户传入的参数是否为空
        if (cls == null) {
            throw new IllegalArgumentException("参数不能为空！");
        }

        ClassLoader loader = cls.getClassLoader();
        // 获得类的全名，包括包名
        String clsName = cls.getName();
        // 此处简单判定是否是Java基础类库，防止用户传入JDK内置的类库
        if (clsName.startsWith("java.") || clsName.startsWith("javax.")) {
            throw new IllegalArgumentException("不要传送系统类！");
        }
        // 将类的class文件全名改为路径形式
        String clsPath = clsName.replace(".", "/") + ".class";

        // 调用ClassLoader的getResource方法，传入包含路径信息的类文件名
        java.net.URL url = loader.getResource(clsPath);
        // 从URL对象中获取路径信息
        String realPath = url.getPath();
        // 去掉路径信息中的协议名"file:"
        int pos = realPath.indexOf("file:");
        if (pos > -1) {
            realPath = realPath.substring(pos + 5);
        }
        // 去掉路径信息最后包含类文件信息的部分，得到类所在的路径
        pos = realPath.indexOf(clsPath);
        realPath = realPath.substring(0, pos - 1);
        // 如果类文件被打包到JAR等文件中时，去掉对应的JAR等打包文件名
        if (realPath.endsWith("!")) {
            realPath = realPath.substring(0, realPath.lastIndexOf("/"));
        }
        java.io.File file = new java.io.File(realPath);
        realPath = file.getAbsolutePath();

        try {
            realPath = java.net.URLDecoder.decode(realPath, "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return realPath;
    }// getAppPath定义结束

    public static void main(String[] args) {
        System.out.println(getRealPath());
        System.out.println(getProjectPath());
    }


}
