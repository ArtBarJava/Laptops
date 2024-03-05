
public class ManyLaptops {
    private String model;
    private int ram;
    private int storage;
    private String operatingSystem;
    private String motherboard;

    public ManyLaptops(String model, int ram, int storage, String operatingSystem, String motherboard) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.motherboard = motherboard;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }


    public String getMotherboard() {
        return motherboard;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "model='" + model + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", motherboard='" + motherboard + '\'' +
                '}';
    }
}