package aplicacion;
import java.io.Serializable;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class MonkeyException extends Exception implements  Serializable{
	public final static String ERROR_IO="Se produjo un error de IO";
	public MonkeyException(String menssage) {
		super(menssage);
	}
}
