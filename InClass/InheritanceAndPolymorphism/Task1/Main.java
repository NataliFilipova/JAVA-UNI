package Nbu.java;

import Repo.*;

public class Main {

    public static void main(String[] args) {
        Author authorIvanov = new Author("Ivanov");
        Book book1 = new Book();
        Book book2 = new Book(1.2, "pdf", "Book 1", authorIvanov, "1234");


        Novel novel1 = new Novel(2, "pdf", "Novel 1", authorIvanov, "6789", "Abstraction novel1");


        Repo repo = new Repo(100, 0, 0);
        repo.storeDocument(book2);
        System.out.println(repo);


    }
}
