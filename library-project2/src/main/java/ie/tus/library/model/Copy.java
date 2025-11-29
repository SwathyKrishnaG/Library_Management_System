package ie.tus.library.model;

public class Copy {
    private final String copyId;
    private final String isbn;
    private CopyStatus status;

    public Copy(String copyId, String isbn) {
        this.copyId = copyId;
        this.isbn = isbn;
        this.status = CopyStatus.AVAILABLE;
    }

    public String getCopyId() { return copyId; }
    public String getIsbn() { return isbn; }
    public CopyStatus getStatus() { return status; }
    public void setStatus(CopyStatus status) { this.status = status; }
    public boolean isAvailable() { return this.status == CopyStatus.AVAILABLE; }

    @Override
    public String toString() {
        return "Copy[" + copyId + ", isbn=" + isbn + ", status=" + status + "]";
    }
}
