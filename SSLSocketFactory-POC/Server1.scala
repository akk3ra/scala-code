import javax.net.ssl.SSLServerSocketFactory
import javax.net.ssl.SSLServerSocket
import javax.net.ssl.SSLSocket
import java.io.InputStreamReader
import java.io.BufferedReader

class Server {
	def main(args:Array[String]){
		val sssf = SSLServerSocketFactory.getDefault()
		val sss = sssf.createServerSocket(1234)
		val ss = sss.accept()

		val is = ss.getInputStream()
		val br = new BufferedReader(new InputStreamReader(is))
		var line:String = ""
		while((line = br.readLine())!=null){
			println(line)
		}
	}
}

