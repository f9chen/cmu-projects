package dao;

import databeans.Note;
import org.mybeans.factory.BeanFactory;
import org.mybeans.factory.BeanFactoryException;
import org.mybeans.factory.BeanTable;
import org.mybeans.factory.DuplicateKeyException;
import org.mybeans.factory.RollbackException;
import org.mybeans.factory.Transaction;

/**
 * Product Version: NetBeans IDE 7.1 (Build 201112071828)
 *
 * @author Fan Chen
 */
public class NoteDAOFactoryImpl implements NoteDAO {

    private BeanFactory<Note> factory;
    private String jdbcDriver;
    private String jdbcURL;

    public NoteDAOFactoryImpl(String jdbcDriver, String jdbcURL) throws MyDAOException {
        this.jdbcDriver = jdbcDriver;
        this.jdbcURL = jdbcURL;

        try {
            BeanTable<Note> table = BeanTable.getSQLInstance(Note.class, "fanc_note", jdbcDriver, jdbcURL);
            if (!table.exists()) {
                table.create("content","courseName","createdBy","timestamp");
            }
            factory = table.getFactory();
        } catch (BeanFactoryException e) {
            throw new MyDAOException(e);
        }
    }

    @Override
    public synchronized Note createNote(String content, String courseName, String createdBy, String timestamp) throws MyDAOException {
        try {
            Transaction.begin();
            Note newNote = factory.create(content,courseName,createdBy,timestamp);
            Transaction.commit();
            return newNote;
        } catch (DuplicateKeyException e) {
            throw new MyDAOException("An exact same note already exists.");
        } catch (RollbackException e) {
            throw new MyDAOException(e);
        }
    }
}