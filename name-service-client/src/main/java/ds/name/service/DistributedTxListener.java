package ds.name.service;

public interface DistributedTxListener {
    void onGlobalCommit();
    void onGlobalAbort();
}