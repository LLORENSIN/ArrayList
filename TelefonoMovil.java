import java.util.ArrayList;

class TelefonoMovil {
    String myNumber;
    ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    private int findContact(Contacto contacto) {
        return myContacts.indexOf(contacto);
    }


    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewContact(Contacto contacto) {
        if (findContact(contacto) == -1) {
            myContacts.add(contacto);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contacto contactoViejo, Contacto contactoNuevo) {
        int index = findContact(contactoViejo);
        if (index != -1) {
            myContacts.set(index, contactoNuevo);
            return true;
        }

        return false;
    }


    public boolean removeContact(Contacto contacto) {
        int index = findContact(contacto);
        if (index != -1) {
            myContacts.remove(index);
            return true;
        }
        return false;
    }

    public Contacto queryContact(String name){
        int index= findContact(name);
        if(index != -1){
           return myContacts.get(index);
        }
        return null;
    }

    public void printContacts(){
        for(int i = 0; i<myContacts.size(); i++){
            System.out.println((i+1)+". "+ myContacts.get(i).getName() + " --> " + myContacts.get(i).getphoneNumber());
        }
    }
}