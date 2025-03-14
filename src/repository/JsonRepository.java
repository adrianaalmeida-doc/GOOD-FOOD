import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonRepository {

    // Método para carregar dados de um arquivo JSON usando Gson
    public static <T> List<T> carregarDeJson(String arquivo, TypeToken<List<T>> typeToken) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(arquivo)) {
            return gson.fromJson(reader, typeToken.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para salvar dados em um arquivo JSON usando Gson
    public static <T> void salvarParaJson(List<T> dados, String arquivo) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(dados, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
