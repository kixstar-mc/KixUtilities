package me.kixstar.kixutilities.rabbitmq.nickname;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import me.kixstar.kixutilities.rabbitmq.Packet;

public class NicknameChangePacket extends Packet {

    private String nickname;

    //no args constructor is required for deserialization of packets
    public NicknameChangePacket() {}

    public NicknameChangePacket(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public byte[] serialize() {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(this.nickname);

        return out.toByteArray();
    }

    @Override
    public void deserialize(byte[] raw) {
        ByteArrayDataInput in = ByteStreams.newDataInput(raw);
        this.nickname = in.readUTF();
    }


    public String getNickname() {
        return nickname;
    }
}
