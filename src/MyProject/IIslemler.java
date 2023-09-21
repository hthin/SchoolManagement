package MyProject;

public interface IIslemler {
    /*
    Interfacelerde metotlar public ve abstract olduğu için aşağıda sönük gözüküyor.
     */
    public abstract void ekleme() throws InterruptedException;
    void arama();
    void listeleme();
    void silme();
    void anaMenu() throws InterruptedException;
    void cikis();

}
