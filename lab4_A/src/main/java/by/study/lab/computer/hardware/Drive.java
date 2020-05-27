package by.study.lab.computer.hardware;

import java.util.Objects;

public class Drive {
    private String name;
    private String type;
    private String connection;

    public Drive() {
        name = "Temp Drive";
        type = "DVD-RW";
        connection = "USB";
    }
    public Drive(String name, String type, String connection) {
        this.name = name;
        this.type = type;
        this.connection = connection;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getConnection() {
        return connection;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setConnection(String connection) {
        this.connection = connection;
    }

    @Override
    public String toString() {
        return "Drive{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", connection='" + connection + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Drive drive = (Drive) object;
        return name.equals(drive.name) &&
                type.equals(drive.type) &&
                connection.equals(drive.connection);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, type, connection);
    }
}
