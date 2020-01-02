package com.raoulvdberge.refinedpipes.network;

import com.raoulvdberge.refinedpipes.network.graph.NetworkGraph;
import com.raoulvdberge.refinedpipes.network.graph.NetworkGraphScannerResult;
import com.raoulvdberge.refinedpipes.render.Color;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Random;

public class Network {
    private final NetworkGraph graph = new NetworkGraph(this);
    private final String id;
    private final Color color;

    public Network() {
        Random r = new Random();

        this.id = generateRandomString(r, 8);
        this.color = new Color(
            r.nextInt(255) + 1,
            r.nextInt(255) + 1,
            r.nextInt(255) + 1
        );
    }

    public String getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public NetworkGraphScannerResult scanGraph(World originWorld, BlockPos originPos) {
        return graph.scan(originWorld, originPos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Network network = (Network) o;
        return id.equals(network.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private static String generateRandomString(Random r, int length) {
        StringBuilder word = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int tmp = 'a' + r.nextInt('z' - 'a');
            word.append((char) tmp);
        }
        return word.toString();
    }
}