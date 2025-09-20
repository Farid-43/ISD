// Step 1: New Interface
interface ModernPrinter {
    void printDocument(String text);
}

// Step 2: Old Legacy Printer
class LegacyPrinter {
    public void oldPrint(String msg) {
        System.out.println("Legacy Printer Output: " + msg);
    }
}

// Step 3: Adapter Class
class PrinterAdapter implements ModernPrinter {
    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void printDocument(String text) {
        // Translate modern request to legacy call
        legacyPrinter.oldPrint(text);
    }
}

// Step 4: Test Main Class
public class Task2 {
    public static void main(String[] args) {
        // Using old printer directly
        LegacyPrinter oldPrinter = new LegacyPrinter();
        oldPrinter.oldPrint("Printing with old system...");

        // Using modern printer interface with Adapter
        ModernPrinter modernPrinter = new PrinterAdapter(new LegacyPrinter());
        modernPrinter.printDocument("Printing with new system via Adapter...");
    }
}
