package com.codeclan.example.FilesAndFolders.components;

import com.codeclan.example.FilesAndFolders.models.File;
import com.codeclan.example.FilesAndFolders.models.Folder;
import com.codeclan.example.FilesAndFolders.models.User;
import com.codeclan.example.FilesAndFolders.repositories.FileRepository;
import com.codeclan.example.FilesAndFolders.repositories.FolderRepository;
import com.codeclan.example.FilesAndFolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        File file1 = new File("Games", "txt", 100);
        File file2 = new File("Code", "md", 100);
        File file3 = new File("Photos", "psd", 200);
        File file4 = new File("MorePhotos", "wav", 256);
        Folder folder1 = new Folder("BigFolder");
        Folder folder2 = new Folder("Smallerfolder");
        User user1 = new User("Jimbo");

        folder1.addFile(file1);
        folder1.addFile(file2);
        folder2.addFile(file3);
        folder2.addFile(file4);

        user1.addFolder(folder1);
        user1.addFolder(folder2);

        fileRepository.save(file1);
        fileRepository.save(file2);
        fileRepository.save(file3);
        fileRepository.save(file4);

        folderRepository.save(folder1);
        folderRepository.save(folder2);

        userRepository.save(user1);
    }
}