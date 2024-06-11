import java.util.Scanner;

public class Iphone implements MusicPlayer, Telephone, Browser {
    private Scanner scanner = new Scanner(System.in);
    private String selectedMusic = null;

    public Iphone(){}

    private String getSelectedMusic() {
        return selectedMusic;
    }

    public void init(){
        while (true) {
            Integer change;
            print("Escolha uma opção:");
            print("0 - Desligar");
            print("1 - Reproduzir Música");
            print("2 - Pausar Música");
            print("3 - Selecionar Música");
            print("4 - Exibir página");
            print("5 - Abrir nova Aba");
            print("6 - Atualizr página");
            print("7 - telefonar");
            print("8 - atender ligação");
            print("9 - Iniciar Correio de voz");
            change = toInt(input());

            if (change == 1) {
                play();
            } else if (change == 2) {
                pause();
            } else if (change == 3) {
                print("Seleciona o nome da música:");
                selectMusic(input());
            } else if (change == 4) {
                print("Seleciona o link da página:");
                displayPage(input());
            } else if (change == 5) {
                addNewTab();
            } else if (change == 6) {
                refreshPage();
            } else if (change == 7) {
                call(input());
            } else if (change == 8) {
                answer();
            } else if (change == 9) {
                startVoicemail();
            } else if (change == 0) {
                print("Iphone Desligado!");
                break;
            }else {
                print("Comando invalido!");
            }
        }
    }

    @Override
    public void play() {
        if(getSelectedMusic() == null){
            System.out.println("Para tocar música, primeiro selecione!");
            return;
        }
        System.out.println("Tocando música: "+getSelectedMusic());
    }
    @Override
    public void pause() {
        System.out.println("Música pausada!");
    }
    @Override
    public void selectMusic(String music) {
        this.selectedMusic = music;
        System.out.println("Musica Selecionada");
    }
    @Override
    public void displayPage(String url) {
        System.out.println("Exibindo página com link:"+url);
    }
    @Override
    public void addNewTab() {
        System.out.println("Nova aba aberta!");
    }
    @Override
    public void refreshPage() {
        System.out.println("página atualizada!");
    }
    @Override
    public void call(String number) {
        System.out.println("Chamando numero: "+number);
    }
    @Override
    public void answer() {
        System.out.println("Ligação atendida!");
    }
    @Override
    public void startVoicemail() {
        System.out.println("Correio de voz iniciado!");
    }

    private void print(Object obj){
        System.out.println(obj);
    }
    private String input(){
        return scanner.nextLine();
    }
    private int toInt(String text){
        int num;
        try{
            num = Integer.parseInt(text);
        }catch (Exception e){
            num = -1;
        }
        return num;
    }
}
