package com.example.semgtest1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.semgtest1.MyDBOpenHelper;

/**
 * @author glsite.com
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public class ContactInfoDao {


    private final MyDBOpenHelper helper;

    public ContactInfoDao(Context context) {
        helper = new MyDBOpenHelper(context);
    }

    /**
     * 添加一条记录
     *
     * @param name
     *          联系人姓名
     * @param phone
     *          联系人电话
     */
    public void add(String name, String phone) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        db.insert("contactinfo", null, values);
        // 记得关闭数据库释放资源
        db.close();
    }

    /**
     * 删除一条记录
     *
     * @param name
     *          联系人姓名
     */
    public void delete(String name) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("contactinfo", "name=?", new String[]{name});
        // 记得关闭数据库释放资源
        db.close();
    }

    /**
     * 添加联系人电话号码
     *
     * @param name
     *          联系人姓名
     * @param phone
     *          联系人电话
     */
    public void update(String name, String phone) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone", phone);
        db.update("contactinfo", values, "name=?", new String[]{name});
        // 记得关闭数据库释放资源
        db.close();
    }

    /**
     * 查询联系人的电话号码
     * @param name
     *          联系人姓名
     * @return  联系人电话
     */
    public String queryName(String name) {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("contactinfo", new String[]{"phone"}, "name=?",
                new String[]{name}, null, null, null);
        String phone = null;
        if (cursor.moveToNext()) {
            phone = cursor.getString(0);
        }
        cursor.close();
        // 记得关闭数据库释放资源
        db.close();
        return phone;
    }


    public boolean login(String name,String phone){
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql="select * from contactinfo where name=? and phone=?";
        Cursor cursor=db.rawQuery(sql, new String[]{name,phone});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
}
