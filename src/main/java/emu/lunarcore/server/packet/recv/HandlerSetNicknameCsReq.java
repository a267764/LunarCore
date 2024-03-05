package emu.lunarcore.server.packet.recv;

import emu.lunarcore.proto.SetNicknameCsReqOuterClass.SetNicknameCsReq;
import emu.lunarcore.server.game.GameSession;
import emu.lunarcore.server.packet.CmdId;
import emu.lunarcore.server.packet.Opcodes;
import emu.lunarcore.server.packet.PacketHandler;
import emu.lunarcore.server.packet.send.PacketSetNicknameScRsp;
import emu.lunarcore.server.packet.send.PacketSetSignatureScRsp;

@Opcodes(CmdId.SetNicknameCsReq)
public class HandlerSetNicknameCsReq extends PacketHandler {

    @Override
    public void handle(GameSession session, byte[] data) throws Exception {
        var req = SetNicknameCsReq.parseFrom(data);

        if (req.getNickname() != null) {
            session.getPlayer().setNickname(req.getNickname());
        }

        session.send(CmdId.SetNicknameScRsp);
        // session.send(new PacketSetNicknameScRsp(session.getPlayer()));
    }

}
