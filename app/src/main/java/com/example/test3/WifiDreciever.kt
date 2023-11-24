package com.example.test3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.p2p.WifiP2pManager
import android.os.Looper

class WifiDreciever : BroadcastReceiver {
    private lateinit var manager: WifiP2pManager
    private lateinit var channel: WifiP2pManager.Channel
    private lateinit var activity: PeersView

    constructor(
        manager: WifiP2pManager,
        channel: WifiP2pManager.Channel,
        activity: PeersView
    ) : super() {
        this.manager = manager
        this.channel = channel
        this.activity = activity
    }

   // fun initialize(
   //     srcLooper: Looper,
   //     srcContext: Context!,
   //     listener: WifiP2pManager.ChannelListener!
   // ): WifiP2pManager.Channel!

    override fun onReceive(context: Context?, intent: Intent?) {
        val action: String? = intent?.action
        when (action) {
            WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION -> {
                // Check to see if Wi-Fi is enabled and notify appropriate activity
                //val state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1)
                //activity.isWifiP2pEnabled = state == WifiP2pManager.WIFI_P2P_STATE_ENABLED
            }

            WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION -> {
                // Call WifiP2pManager.requestPeers() to get a list of current peers
                if(manager!=null){
                    manager.requestPeers(channel, activity.peerListListener)
                }
            }

            WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION -> {
                // Respond to new connection or disconnections

            }

            WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION -> {
                // Respond to this device's wifi state changing
            }
        }
    }
}
