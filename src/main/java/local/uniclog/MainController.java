package local.uniclog;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MainController {
    @FXML
    private TextField fieldInput;
    @FXML
    private Label labelOutput;

    @FXML
    public void initialize() {
        System.out.println("init main controller");
    }

    @FXML
    public String actionConvertToMd5() throws NoSuchAlgorithmException {
        byte[] bytesOfMessage = fieldInput.getText().getBytes(StandardCharsets.UTF_8);
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        String hash = Integer.toHexString(Arrays.hashCode(messageDigest.digest(bytesOfMessage)));
        labelOutput.setText(hash);
        return hash;
    }
}