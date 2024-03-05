package emu.lunarcore.server.packet.send;

import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.SetNicknameScRspOuterClass;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketSetNicknameScRsp extends BasePacket {

    public PacketSetNicknameScRsp(Player player) {
        super(CmdId.SetSignatureScRsp);

        var data = SetNicknameScRspOuterClass.SetNicknameScRsp.newInstance()
            .setIsModify(true);

        this.setData(data);
    }
}
