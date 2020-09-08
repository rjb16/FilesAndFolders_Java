package com.codeclan.example.FilesAndFolders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class File {

    @Column
    private String name;

    @Column
    private String extension;

    @Column
    private Long size;

    @JsonIgnoreProperties({"files"})
    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    private Folder folder;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public File(String name, String extension, long size) {
        this.name = name;
        this.extension = extension;
        this.size = size;
    }

    public File() {
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public long getSize() {
        return size;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }
}