package general;

import java.util.UUID;

public class PipeCut {

    private UUID uuid;

    private String[] rowData;
    private String service;
    private int rawLength;

    public PipeCut() {
        uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String[] getRowData() {
        return rowData;
    }

    public void setRowData(String[] rowData) {
        this.rowData = rowData;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getRawLength() {
        return rawLength;
    }

    public void setRawLength(int rawLength) {
        this.rawLength = rawLength;
    }




}
