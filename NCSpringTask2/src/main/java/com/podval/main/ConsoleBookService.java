package com.podval.main;

import com.podval.models.Book;
import com.podval.models.IModel;
import com.podval.services.BookService;

public class ConsoleBookService extends ConsoleObjectService {

    public ConsoleBookService(){
        super(Book.class, new BookService());
    }

    @Override
    public IModel init() {
        System.out.println("------------Init book----------------");

        return new Book(
                (String) IConsoleMainService.getObjectFromInput("Input name: "),
                Integer.parseInt((String) IConsoleMainService.getObjectFromInput("Input price: ")),
                (String) IConsoleMainService.getObjectFromInput("Input warehouse: "),
                Integer.parseInt((String) IConsoleMainService.getObjectFromInput("Input count: "))
        );
    }
}
