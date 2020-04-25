package com.netcracker.service;

import com.netcracker.model.User;
import com.netcracker.repository.UserRepository;
import com.netcracker.service.*;
import com.netcracker.controller.UserController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextSaver {

    public static void saveText(User user){
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
            List<String> oldLines = new ArrayList<>();
            while (reader.ready())
            {
                oldLines.add(reader.readLine());
            }
            reader.close();


            FileWriter writer = new FileWriter("user.txt", false);
            //writer.append('\n');
            for (String s: oldLines)
            {
                writer.append(s);
                writer.append('\n');
            }


            writer.append(user.toString());
            writer.close();
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
