package br.com.saude.app.project.activity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.saude.app.project.R;
import br.com.saude.app.project.db.DatabaseHelper;
import br.com.saude.app.project.model.Usuario;

/**
 * Created by tawan on 3/2/17.
 */

public class CreateUserActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    //UsuarioAdapter adaptador;
    private List<Usuario> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void addFixelsUsuario() {
        dbHelper = new DatabaseHelper(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", "nome");
        values.put("email", "nome");
        values.put("senha", "nome");
        long result = db.insert("usuario", null, values);

        if (result != -1) {
            Toast.makeText(this, getString(R.string.msg_usuario_cadastrado_sucesso), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.msg_usuario_cadastrado_falha), Toast.LENGTH_SHORT).show();
        }

        db.execSQL("INSERT INTO usuario (nome, email, senha) VALUES ('Teste', 'teste@teste.com', 'hsbds7ew*#isnfu3*Ye73byd37&*e37')");
    }

    public List<Usuario> listUsuarios() {
        List<Usuario> result = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id, nome, email, senha FROM usuario", null);
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getLong(0));
            usuario.setNome(cursor.getString(1));
            usuario.setEmail(cursor.getString(2));
            usuario.setSenha(cursor.getString(1));

            result.add(usuario);
        }
        return result;
    }
}
