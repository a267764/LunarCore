package emu.lunarcore.server.packet.send;

import emu.lunarcore.game.player.Player;
import emu.lunarcore.proto.AnnounceDataOuterClass;
import emu.lunarcore.proto.ServerAnnounceNotifyOuterClass;
import emu.lunarcore.proto.StaminaInfoScNotifyOuterClass.StaminaInfoScNotify;
import emu.lunarcore.server.packet.BasePacket;
import emu.lunarcore.server.packet.CmdId;

public class PacketStaminaInfoScNotify extends BasePacket {

    public PacketStaminaInfoScNotify(Player player) {
        super(CmdId.StaminaInfoScNotify);

        var data = StaminaInfoScNotify.newInstance()
            .setNextRecoverTime(player.getNextStaminaRecover() / 1000)
            .setStamina(player.getStamina())
            .setReserveStamina((int) Math.floor(player.getStaminaReserve()));

        this.setData(data);

        try {
            var announce = ServerAnnounceNotifyOuterClass.ServerAnnounceNotify.newInstance()
                .addAnnounceDataList(AnnounceDataOuterClass.AnnounceData.newInstance()
                    // .setText("Edit by Linnnxiannn.")
                    .setText(String.format("Never gonna give U up, Never gonna let U down"))
                    .setConfigId(0)
                    .setEndTime(2021978774)
                    .setCountDownFrequency(0)
                    .setCenterSystemFrequency(0)
                    .setBeginTime(0)
                    .setUnkbool(false)
                );


            Packet packet = new Packet();
            packet.setCmdId(CmdId.ServerAnnounceNotify);
            packet.setData(announce);

            player.getSession().send(packet);
        } catch (Exception e) {
            player.getSession().close();
        }
    }
}
