package jointfaas;
import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.FunctionInitializer;
import com.aliyun.fc.runtime.StreamRequestHandler;

import java.io.*;

public class AliIndex implements StreamRequestHandler, FunctionInitializer {
    private Index handler;
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        handler.handle(inputStream, outputStream);
    }

    @Override
    public void initialize(Context context) throws IOException {
        handler = new Index();
    }
}