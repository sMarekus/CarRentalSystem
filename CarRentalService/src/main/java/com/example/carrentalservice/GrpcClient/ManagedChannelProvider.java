package com.example.carrentalservice.GrpcClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ManagedChannelProvider {

    private static ManagedChannel channel;
    private static final Lock lock = new ReentrantLock();

    private ManagedChannelProvider() {
    }

    /**
     * Retrieves the managed channel instance.
     *
     * @return The ManagedChannel instance.
     */
    public static ManagedChannel getChannel(){
        if(channel == null){
            synchronized (lock){
                if (channel == null){
                    channel = ManagedChannelBuilder.forAddress("localhost",
                                    5217)
                            .usePlaintext()
                            .build();
                }
            }
        }
        return channel;
    }
}
