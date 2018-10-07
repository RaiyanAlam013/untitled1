package com.srps.gui;
import com.srps.database.*;
import com.srps.gui.FormEvent;

import java.util.EventListener;

public interface FormEventListener extends EventListener {
    public void FormEventOccuder(FormEvent e);
}
