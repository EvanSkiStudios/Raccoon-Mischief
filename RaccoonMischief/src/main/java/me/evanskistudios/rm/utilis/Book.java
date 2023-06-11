package me.evanskistudios.rm.utilis;

import me.evanskistudios.rm.RaccoonMischief;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.logging.Level;

public class Book {
    RaccoonMischief plugin;
    String title;
    String author;
    String currentPage = "";
    int numPages = 0;
    int numLines = 0;

    ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
    BookMeta bookMeta = (BookMeta) book.getItemMeta();

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getNumPages() {
        return numPages;
    }

    public void setTitle(String title) {
        this.title = title;
        bookMeta.setTitle(title);
    }
    public void setAuthor(String author) {
        this.author = author;
        bookMeta.setAuthor(author);
    }
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void addPage () {
        bookMeta.addPage(currentPage);
        ++numPages;
    }

    public void addToPage (String line) {
        if (numLines == 13) {
            //needs edge case for adding lines
            // on new page


            addPage();
            this.currentPage = "";
            this.numLines = 0;
        } else {
            this.currentPage = this.currentPage + line + "\n";
        }

        ++numLines;
    }

    public void addInfo() {
        book.setItemMeta(bookMeta);
    }

    public void giveBook(Player p) {
        if (p.getInventory().firstEmpty() != -1) {
            p.getInventory().addItem(book);
        } else {
            //p.sendMessage("cant give you " + title + " book, your inventory is full!");
            plugin.getLogger().log(Level.FINE,"Could not give "+p.getDisplayName()+" a book , their inventory is full!!");
        }
    }


}
