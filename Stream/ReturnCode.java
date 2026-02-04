package Stream;

public class ReturnCode {
    String id;
    String code;
    String description;

    // Default Constructor (Use for Object creation without data)
    public ReturnCode() {
    }

    // Parametarized Constructor
    public ReturnCode(String id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    // Get Id
    public String getId() {
        return id;
    }

    // Get Code
    public String getCode() {
        return code;
    }

    // Get Description
    public String getDescription() {
        return description;
    }

    // Set Id
    public void setId(String id) {
        this.id = id;
    }

    // Set Code
    public void setCode(String code) {
        this.code = code;
    }

    // Set Description
    public void setDescription(String description) {
        this.description = description;
    }
}
