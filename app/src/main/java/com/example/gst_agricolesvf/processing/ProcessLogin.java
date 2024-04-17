package com.example.gst_agricolesvf.processing;

import com.example.gst_agricolesvf.vm.VmAgricoles;

import io.socket.client.Socket;

public class ProcessLogin {

    VmAgricoles vmAgricoles;
    Socket socket;
    public ProcessLogin() {
    }

    public ProcessLogin(VmAgricoles vmAgricoles, Socket socket) {
        this.vmAgricoles = vmAgricoles;
        this.socket = socket;
    }

    public void Login(){
        socket.emit("");
    }

}
