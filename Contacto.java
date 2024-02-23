class Contacto{
    String name;
    String phoneNumber;

    public Contacto (String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public String getName() {
        return name;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacto contacto = (Contacto) o;

        if (!name.equals(contacto.name)) return false;
        return phoneNumber.equals(contacto.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

    public static Contacto createContact(String name, String phoneNumber){
        return new Contacto(name,phoneNumber);
    }
}

