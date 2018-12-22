package com.podval.web;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class recordsManager {

    private static final String USERS_FILE = "/data/users.txt";

    public static Users getUsers(ServletContext context) throws IOException {
        return new Users(Files.lines(Paths.get(context.getRealPath(USERS_FILE)), StandardCharsets.UTF_8).toArray());
    }

    public static boolean isKnownUser(ServletContext context, User user) throws IOException {
        return getUsers(context).get(user.getLogin()) != Users.NO_USER;
    }

    public static boolean isKnownUser(ServletContext context, String login) throws IOException {
        return getUsers(context).get(login) != Users.NO_USER;
    }

    public static boolean isValidPassword(ServletContext context, User user) throws IOException {
        return getUsers(context).get(user.getLogin()).getPassword().equals(user.getPassword());
    }

    public static Boolean deleteRow(String row, ServletContext context) throws IOException {
        Path usersFilePath = Paths.get(context.getRealPath(USERS_FILE));
        String rootPath = usersFilePath.getParent().toString();
        File tmpFile = File.createTempFile("temp", ".txt", new File(rootPath));
        Path tmpFilePath = Paths.get(tmpFile.getPath());
        Writer toTmpWriter = Files.newBufferedWriter(tmpFilePath);

        Files.lines(Paths.get(context.getRealPath(USERS_FILE))).forEach( string -> {
            try {
                if(!string.split(" ")[0].equals(row)) {
                    toTmpWriter.write(System.lineSeparator() + string);
                    toTmpWriter.flush();
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        });


        Writer toUsersWriter = Files.newBufferedWriter(usersFilePath);
        Files.lines(tmpFilePath).forEach( string -> {
            try {
                toUsersWriter.write(System.lineSeparator() + string);
                toUsersWriter.flush();

            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        });

        //Boolean success = tmpFile.renameTo(new File(usersFilePath.toString()));
        Boolean success = tmpFile.delete();

        return success;
    }

    public static void addRecord(ServletContext context, User user) throws IOException {
        Path path = Paths.get(context.getRealPath(USERS_FILE));
        BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND);
        writer.write(System.lineSeparator() + user.toString());
        writer.flush();
    }

}
