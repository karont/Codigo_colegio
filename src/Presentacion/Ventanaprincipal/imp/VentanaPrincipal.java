/**
 * 
 */
package Presentacion.Ventanaprincipal.imp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Alex
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Presentacion.Alumno.singleton.GUIAlumno;
import Presentacion.Asignatura.singleton.GUIAsignatura;
import Presentacion.Grupo.singleton.GUIGrupo;

public class VentanaPrincipal extends JFrame{


		private static final long serialVersionUID = 1L;
		
		private JPanel contentPane;
		private JButton btnGrupo;
		private JButton btnAlumnos;
		private JButton btnAsignatura;
		
		private VentanaPrincipal mySelf;

		/**
		 * Create the frame.
		 */
		public VentanaPrincipal() {
			
			setPreferredSize(new Dimension(900, 500));
			setMinimumSize(new Dimension(100, 100));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 900, 600);
			setTitle("Colegio");
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu mnArchivo = new JMenu("Archivo");
			menuBar.add(mnArchivo);
			
			JMenuItem mntmSalir = new JMenuItem("Salir");
			mntmSalir.addActionListener(new ActionListener() {
			    
			    @Override
			    public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			    }
			});
			//mntmSalir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons/Salir16.png")));
			mnArchivo.add(mntmSalir);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			
			
			JToolBar toolBar = new JToolBar();
			toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
			toolBar.setBackground(new Color(245, 245, 245));
			toolBar.setMinimumSize(new Dimension(13, 23));
			toolBar.setMaximumSize(new Dimension(150, 23));
			contentPane.add(toolBar, BorderLayout.NORTH);
			
			Component cajaFlecibleIz = Box.createGlue();
			toolBar.add(cajaFlecibleIz);
			
			
			
			btnGrupo = new JButton("Grupo");
			btnGrupo.setHorizontalTextPosition(SwingConstants.CENTER);
			btnGrupo.setToolTipText("Abre la sección de administración de Grupos");
			//btnGrupo.setRolloverIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons/")));
			btnGrupo.setVerticalTextPosition(SwingConstants.BOTTOM);
			//btnGrupo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons/")));
			
			btnGrupo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					btnGrupo.setEnabled(false);

					Component c = ((BorderLayout)contentPane.getLayout()).getLayoutComponent(BorderLayout.CENTER);
					
					if ( c != null ) {
						
						contentPane.remove(c);
						contentPane.repaint();
					}
					
					
					JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
					tabbedPane.add("Alta Grupo", GUIGrupo.getInstance().getPanelAltaGrupo());
					tabbedPane.add("Baja Grupo", GUIGrupo.getInstance().getPanelBajaGrupo());
					tabbedPane.add("Consulta Grupo", GUIGrupo.getInstance().getPanelConsultaGrupo());
					
					contentPane.add(tabbedPane, BorderLayout.CENTER);
					contentPane.validate();
					
					btnAlumnos.setEnabled(true);
					btnAsignatura.setEnabled(true);
				}
			});
			
			toolBar.add(btnGrupo);
			
			btnAlumnos = new JButton("Alumnos");
			btnAlumnos.setHorizontalTextPosition(SwingConstants.CENTER);
			btnAlumnos.setMnemonic(KeyEvent.VK_E);
			btnAlumnos.setToolTipText("Abre la sección de administración de Alumnos");
			btnAlumnos.setVerticalTextPosition(SwingConstants.BOTTOM);
			//btnAlumnos.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons/")));
			//btnAlumnos.setRolloverIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons/")));
			
			btnAlumnos.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					btnAlumnos.setEnabled(false);

					Component c = ((BorderLayout)contentPane.getLayout()).getLayoutComponent(BorderLayout.CENTER);
					
					if ( c != null ) {
						
						contentPane.remove(c);
						contentPane.repaint();
					}
				
					JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
					tabbedPane.add("Alta Alumnos", GUIAlumno.getInstance().getPanelAltaAlumno());
					tabbedPane.add("Baja Alumnos", GUIAlumno.getInstance().getPanelBajaAlumno());
					tabbedPane.add("Modificación Alumnos", GUIAlumno.getInstance().getPanelModificarAlumno());
					tabbedPane.add("Consulta Alumnos", GUIAlumno.getInstance().getPanelConsultaAlumno());
					tabbedPane.add("Consulta múltiple Alumnos", GUIAlumno.getInstance().getPanelConsultaMultipleAlumnos());
//					tabbedPane.add("Consulta alumnos por curso", GUIAlumno.getInstance().getPanelConsutlaAlumnosPorCurso());
//					tabbedPane.add("Asignar curso", GUIAlumno.getInstance().getPanelAsignarCursoAlumno());
					
					contentPane.add(tabbedPane, BorderLayout.CENTER);
					contentPane.validate();

					btnGrupo.setEnabled(true);
					btnAsignatura.setEnabled(true);
				}
			});
			
			toolBar.add(btnAlumnos);
			
			btnAsignatura = new JButton("Asignatura");
			//btnAsignatura.setRolloverIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons/")));
			//btnAsignatura.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/icons/")));
			btnAsignatura.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnAsignatura.setHorizontalTextPosition(SwingConstants.CENTER);
			
			btnAsignatura.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					btnAsignatura.setEnabled(false);

					Component c = ((BorderLayout)contentPane.getLayout()).getLayoutComponent(BorderLayout.CENTER);
					
					if ( c != null ) {
						
						contentPane.remove(c);
						contentPane.repaint();
					}
					
					JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
					tabbedPane.add("Alta tareas", GUIAsignatura.getInstance().getPanelAltaAsignatura());
					tabbedPane.add("Baja tareas", GUIAsignatura.getInstance().getPanelBajaAsignatura());
					tabbedPane.add("Consulta tareas", GUIAsignatura.getInstance().getPanelConsultarAsignatura());

					
					contentPane.add(tabbedPane, BorderLayout.CENTER);
					contentPane.validate();

					btnGrupo.setEnabled(true);
					btnAlumnos.setEnabled(true);
				}
			});
			
			toolBar.add(btnAsignatura);
			
			Component cajaFlecibleDr = Box.createGlue();
			toolBar.add(cajaFlecibleDr);
			
			setVisible(true);
		}
	}
