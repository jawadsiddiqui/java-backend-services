##Design Patterns

###SOLID
#### SRP (Single Responsibility Principle)

- Class should have single reason to change
- Single class should have one primarily responsibility.

#### Open Close Principle
- when the business requirements change then the entity can be extended, but not modified.

#### Interface Segregation Principle (ISP)
- How to split interfaces

```
interface Machine
{

void print(Document d);
void fax(Document d) throws Exception;
void scan(Document d) throws Exception;
}

// ok if you need a multifunction machine
class MultiFunctionPrinter implements Machine
{
public void print(Document d)
{
//
}

public void fax(Document d)
{
//
}

public void scan(Document d)
{
//
}
}

class OldFashionedPrinter implements Machine
{
public void print(Document d)
{
// yep
}

public void fax(Document d) throws Exception
{
throw new Exception();
}

public void scan(Document d) throws Exception
{
throw new Exception();
}
}

interface Printer
{
void Print(Document d) throws Exception;
}

interface IScanner
{
void Scan(Document d) throws Exception;
}

class JustAPrinter implements Printer
{
public void Print(Document d)
{

}
}

class Photocopier implements Printer, IScanner
{
public void Print(Document d) throws Exception
{
throw new Exception();
}

public void Scan(Document d) throws Exception
{
throw new Exception();
}
}

interface MultiFunctionDevice extends Printer, IScanner //
{

}

class MultiFunctionMachine implements MultiFunctionDevice
{
// compose this out of several modules
private Printer printer;
private IScanner scanner;

public MultiFunctionMachine(Printer printer, IScanner scanner)
{
this.printer = printer;
this.scanner = scanner;
}

public void Print(Document d) throws Exception
{
printer.Print(d);
}

public void Scan(Document d) throws Exception
{
scanner.Scan(d);
} 
}
```
#### Most used Design Patterns

- Singleton Design Pattern.
- Factory Method Design Pattern.
- Facade Design Pattern.
- Strategy Design Pattern.
- Observer Design Pattern.
- Builder Design Pattern.
- Adapter Design Pattern.
